;==========================================================
; Type your student ID and name here.
;==========================================================

(require '[clojure.test :refer [deftest is run-tests]])

;==========================================================
(defn find-unique-evenness-num
  "Returns a vector with the value and index position of the
  only element in lst that has a different evenness from
  the other elements."
  [lst]
  nil)

;==========================================================
(deftest test-find-unique-evenness-num
  (is (= [13 2]
         (find-unique-evenness-num [4 10 13 -16 8 20])))
  (is (= [42 0]
         (find-unique-evenness-num [42 41 39 37 35 33 31])))
  (is (= [0 1]
         (find-unique-evenness-num [1 0 1])))
  (is (= [1 2]
         (find-unique-evenness-num [0 0 1])))
  (is (= [108 25]
         (find-unique-evenness-num [587 239 643 785 409 673
                                    517 91 579 769 567 105
                                    851 489 593 15 949 275
                                    117 387 853 571 687 377
                                    985 108 741 377 349 929
                                    21 921 685 7 987 415
                                    833 27 411 649 249 817
                                    229 711 153 551 777 851
                                    211])))
  (is (= [999 99]
         (find-unique-evenness-num[578 536 910 360 792 94
                                   720 392 308 720 480 360
                                   406 480 10 312 780 310
                                   106 884 276 670 234 830
                                   92 518 98 56 154 810 828
                                   800 336 176 974 572 344
                                   542 18 80 516 406 186 48
                                   132 200 26 240 54 732
                                   782 684 574 122 874 234
                                   38 534 382 314 508 666
                                   26 858 90 646 348 548
                                   788 270 982 520 286 494
                                   536 306 308 272 192 460
                                   122 576 518 70 810 882
                                   144 264 758 746 722 768
                                   152 70 650 934 274 254
                                   14 999 530])))
)

;==========================================================
(run-tests)
