(require '[clojure.core.logic :as logic])

(logic/defne lasto
  "Logical function that succeeds if the
  last element of lst is x."
  [lst x]
  ([[x] x])
  ([[h . t] x]
   (lasto t x)))

(logic/defne dupo
  "Logical function that succeeds if every
  element of lst is duplicates in the result."
  [lst result]
  ([[] []])
  ([[h . t] [h h . r]]
   (dupo t r)))

(logic/defne reverseo
  "Logical function that succeeds if the
  reverse of lst is result."
  [lst result]
  ([[] []])
  ([[h . t] result]
   (logic/fresh [temp]
     (reverseo t temp)
     (logic/appendo temp [h] result))))

(logic/defne twino
  "Logical function that succeeds if lst
  is a sequence of two equal values."
  [lst]
  ([[x x]]))

(logic/defne anti-twino
  "Logical function that succeeds if lst
  is a sequence of two items that are
  not the same."
  [lst]
  ([[x y]]
   (logic/!= x y)))


