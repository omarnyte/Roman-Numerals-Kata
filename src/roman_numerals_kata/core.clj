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
                
(defn convert-roman-to-arabic
  [num]
  (if (perfect-arabic-num? num)
      (get arabic-roman-map num)
      (if (repeatable? num)
          (apply str (repeat (/ num (next-repeatable-down num))
                            (get repeatable-map 
                                  (next-repeatable-down num))))
          (if (= 1 (- (next-up num) num))
              (str "I" (get arabic-roman-map 
                            (next-up num)))
              (str "V" (convert-roman-to-arabic (- num 5)))))))