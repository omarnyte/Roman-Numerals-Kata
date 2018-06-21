(ns roman-numerals-kata.core)

(def arabic-roman-map 
  { 1 "I" 
    5 "V" 
    10 "X" 
    50 "L" 
    100 "C" 
    500 "D" 
    1000 "M" })

(def repeatable-map
  { 1 "I" 
    10 "X"     
    100 "C" 
    1000 "M" })

(defn next-up
  ([num] 
  (first (filter #(<= num %) 
                 (keys arabic-roman-map)))))

(defn next-down
  ([num] 
  (last (filter #(>= num %) 
                 (keys arabic-roman-map)))))

(defn next-repeatable-down
  ([num] 
  (last (filter #(>= num %) 
                 (keys repeatable-map)))))

(defn repeatable?
  [num]
  (if (<= (/ num (next-repeatable-down num)) 3)
      true 
      false))

(defn perfect-arabic-num?
  [num]
  (if (get arabic-roman-map num)
      true
      false))
      
(defn should-reverse?
  [num]
  (and (not (perfect-arabic-num? num))
       (<= (- (next-up num) num)
           (next-repeatable-down num))))
                
(declare convert-roman-to-arabic)
    
(defn convert-imperfect-arabic-num
  [num]
  (if (should-reverse? num)
      (str (get arabic-roman-map (next-repeatable-down num))
           (get arabic-roman-map(next-up num)))
      (str (get arabic-roman-map (next-down num)) 
           (convert-roman-to-arabic (- num 
                                       (next-down num))))))
    
(defn convert-roman-to-arabic
  [num]
  (if (perfect-arabic-num? num)
      (get arabic-roman-map num)
      (convert-imperfect-arabic-num num)))
    
; (declare convert-roman-to-arabic)

; (defn helper-method
;   [num]
;   (let [next-arabic-down (next-repeatable-down num)
;         next-repeatable-roman-down (get arabic-roman-map next-arabic-down)
;         next-arabic-up (next-up num)
;         next-roman-up (get arabic-roman-map next-arabic-up)]
;     (if (repeatable? num)
;             (apply str (repeat (/ num (next-repeatable-down num))
;                                next-repeatable-roman-down))
;             (if (= next-repeatable-roman-down (- next-arabic-up num))
;                 (str next-repeatable-roman-down next-roman-up)
;                 (str "V" (convert-roman-to-arabic (- num 5)))))))
    
; (defn convert-roman-to-arabic
;   [num]
;   (if (perfect-arabic-num? num)
;       (get arabic-roman-map num)
;       (helper-method num)))


            
; (if (= 1 (- (next-up num) num))
;     (str "I" (get arabic-roman-map 
;                   (next-up num)))
;     (str "V" (convert-roman-to-arabic (- num 5)))))))