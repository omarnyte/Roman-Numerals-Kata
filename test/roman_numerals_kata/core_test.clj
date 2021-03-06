(ns roman-numerals-kata.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals-kata.core :refer :all]))
          
(deftest repeatable-test
  (is (= true (repeatable? 3)))
  (is (= false (repeatable? 4)))
  (is (= false (repeatable? 5)))
  (is (= true (repeatable? 10)))
  (is (= true (repeatable? 100)))
  (is (= true (repeatable? 300))))

(deftest perfect-arabic-num-test
  (is (= true (perfect-arabic-num? 1)))
  (is (= false (perfect-arabic-num? 2)))
  (is (= true (perfect-arabic-num? 5)))
  (is (= false (perfect-arabic-num? 6)))
  (is (= true (perfect-arabic-num? 10)))
  (is (= false (perfect-arabic-num? 11))))

(deftest should-reverse-test
  (is (= false (should-reverse? 1)))
  (is (= true (should-reverse? 4)))
  (is (= false (should-reverse? 5)))
  (is (= true (should-reverse? 9)))
  (is (= true (should-reverse? 40))))
          
(deftest convert-roman-to-arabic-test
  (testing "translates 1 to I"
    (is (= "I" (convert-roman-to-arabic 1))))
  (testing "translates 3 to III"
    (is (= "III" (convert-roman-to-arabic 3))))
  (testing "translates 4 to IV"
    (is (= "IV" (convert-roman-to-arabic 4))))
  (testing "translates 5 to V"
    (is (= "V" (convert-roman-to-arabic 5))))
  (testing "translates 8 to VIII"
    (is (= "VIII" (convert-roman-to-arabic 8))))
  (testing "translates 9 to IX"
    (is (= "IX" (convert-roman-to-arabic 9))))
  (testing "translates 30 to XXX"
    (is (= "XXX" (convert-roman-to-arabic 30))))
  (testing "translates 40 to XL"
    (is (= "XL" (convert-roman-to-arabic 40))))
  (testing "translates 300 to CCC"
    (is (= "CCC" (convert-roman-to-arabic 300)))))
  ; (testing "translates 48 to XLIX"
  ;   (is (= "XLIX" (convert-roman-to-arabic 49)))))
