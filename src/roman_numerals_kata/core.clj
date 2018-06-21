(ns roman-numerals-kata.core)

(def roman-arabic-map 
  { 1 "I" 5 "V" 10 "X" 50 "L" 100 "C" 500 "D" 1000 "M"})

(defn next-up
  ([num] 
  (first (filter #(<= num %) 
                 (keys roman-arabic-map)))))

(defn next-down
  ([num] 
  (last (filter #(>= num %) 
                 (keys roman-arabic-map)))))

(defn convert-roman-to-arabic
  [num]
  (if (>= num 4)
    (if (= (- (next-up num) num) 1)
        (str "I" (get roman-arabic-map (next-up num)))
        (str (get roman-arabic-map (next-down num))
             (convert-roman-to-arabic (- num (next-down num)))))
    (apply str (repeat num "I"))))
