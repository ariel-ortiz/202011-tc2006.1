(defn prime?
  "Returns true if n is a prime number, otherwise returns false."
  [n]
  (if (< n 2)
    false
    (loop [i 2]
      (if (<= (* i i) n)
        (if (zero? (rem n i))
          false
          (recur (inc i)))
        true))))
