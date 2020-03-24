(defn compute-pi
  "Approximates the value of Pi using the numerical integration midpoint
  algorithm."
  [num-rects]
  (let [width (/ 1.0 num-rects)]
    (loop [i 0
           sum 0.0]
      (let [mid (* (+ i 0.5) width)
            height (/ 4.0 (+ 1.0 (* mid mid)))]
        (if (= i num-rects)
          (* width sum)
          (recur
            (inc i)
            (+ sum height)))))))