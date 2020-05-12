
(defmacro my-comment
  "Behaves like the comment macro."
  [& things]
  nil)

(defmacro debug
  "Allows debugging an expression
  by printing the expression followed
  by it value."
  [exp]
  `(let [temp# ~exp]
     (printf "Debug: %s => %s%n"
             '~exp
             temp#)
     temp#))

(defn fact
  [n]
  (debug n)
  (if (zero? n)
    1
    (debug (* n (fact (dec n))))))

(defmacro my-and
  "Our own version of the and macro."
  ([] true)
  ([x] x)
  ([x & next]
   `(let [temp# ~x]
      (if temp#
        (my-and ~@next)
        temp#))))

