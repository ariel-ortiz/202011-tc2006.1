(defn compute-pi
  "Approximates the value of Pi using the numerical integration midpoint
  algorithm."
  [num-rects start end]
  (let [width (/ 1.0 num-rects)]
    (loop [i start
           sum 0.0]
      (let [mid (* (+ i 0.5) width)
            height (/ 4.0 (+ 1.0 (* mid mid)))]
        (if (= i end)
          (* width sum)
          (recur
            (inc i)
            (+ sum height)))))))

(defn chunks
  [how-many num-rects]
  (->>
    (range 0 (inc num-rects) (/ num-rects how-many))
    (partition 2 1)
    (map #(cons num-rects %))))

(defn parallel-pi
  [how-many num-rects]
  (let [mid (/ num-rects 2)]
    (->>
      (chunks how-many num-rects)
      (pmap (fn [[num-rects start end]]
              (compute-pi num-rects start end)))
      (reduce +))))
