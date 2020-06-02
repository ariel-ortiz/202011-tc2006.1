(require '[clojure.core.logic :as logic])
(require '[clojure.core.logic.fd :as fd])

(logic/defne sumo
  "Logical function that succeeds if
  the sum of every number in lst is
  result."
  [lst result]
  ([[] 0])
  ([[head . tail] result]
   (logic/fresh [temp]
     (sumo tail temp)
     (fd/+ head temp result))))

(logic/defne largesto
  "Logical function that succeed if
  result is the largest number contained
  in lst."
  [lst result]
  ([[x] x])
  ([[head . tail] head]
   (logic/fresh [temp]
     (largesto tail temp)
     (fd/>= head temp)))
  ([[head . tail] temp]
   (largesto tail temp)
   (fd/> temp head)))
