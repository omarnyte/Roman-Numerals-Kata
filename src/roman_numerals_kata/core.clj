(ns roman-numerals-kata.core)

(def roman-arabic-map 
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
                 (keys roman-arabic-map)))))

(defn next-down
  ([num] 
  (last (filter #(>= num %) 
                 (keys roman-arabic-map)))))

(defn next-repeatable-down
  ([num] 
  (last (filter #(>= num %) 
                 (keys repeatable-map)))))

(defn repeatable?
  [num]
  (if (<= (/ num (next-repeatable-down num)) 3)
      true 
      false))
                
(defn convert-roman-to-arabic
  [num]
  (if (some? (map #(= 3 (/ % 3)) 
                  (keys repeatable-map)))     
      (apply str (repeat num "I"))
      (if (= 1 (- (next-up num) num))
          (str "I" (get roman-arabic-map 
                        (next-up num)))
          (str "V" (convert-roman-to-arabic (- num 5))))))