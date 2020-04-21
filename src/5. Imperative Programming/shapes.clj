(defn square
  "Displays a square of stars of n x n."
  [n]
  (doseq [i (range n)]
    (doseq [j (range n)]
      (print "*"))
    (println)))

(defn triangle
  [h])