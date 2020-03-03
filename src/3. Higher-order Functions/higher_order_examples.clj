(defn my-map
  "My own simple version of map."
  [fun lst]
  (if (empty? lst)
    ()
    (cons (fun (first lst))
          (my-map fun (rest lst)))))

(defn some-fun
  []
  +)

(defn inc-something
  [something]
  (fn [x]
    (+ x something)))

(defn compose
  [f g]
  (fn [x]
    (f (g x))))

(defn f1 [x] (* 3 x))
(defn f2 [x] (+ x 2))
(def f3 (compose f1 f2))
(def f4 (compose f2 f1))
(def f5 (compose f3 f4))