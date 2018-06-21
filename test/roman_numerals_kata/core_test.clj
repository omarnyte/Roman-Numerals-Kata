(ns roman-numerals-kata.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals-kata.core :refer :all]))
          
(deftest convert-roman-to-arabic-test
  (testing "translates 1 to I"
    (is (= "I" (convert-roman-to-arabic 1))))
  (testing "translates 3 to III"
    (is (= "III" (convert-roman-to-arabic 3))))
  (testing "translates 4 to IV"
    (is (= "IV" (convert-roman-to-arabic 4))))
  (testing "translates 5 to V"
    (is (= "V" (convert-roman-to-arabic 5)))))
