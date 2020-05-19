
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

(defmacro bif
  "Binds the condition to a variable.
  If that value is true, evaluates and
  returns de then-part, otherwise
  evaluates and returns the else-part."
  [variable condition then-part else-part]
  `(let [~variable ~condition]
     (if ~variable
       ~then-part
       ~else-part)))

(defn def-vars-helper
  "Creates individual (def var-name-suffix expr)
  lists."
  [var-name expressions]
  (map (fn [n expr]
         `(def ~(symbol (str var-name n)) ~expr))
       (range)
       expressions))

(defmacro def-vars
  "Defines as many global variables as the provided
  number of expressions. The value of var-name is the
  name prefix for all these variables. The suffix
  is “0” for the first variable name, which is
  initialized with the first expression. The next
  variable name has a “1” suffix and is initialized
  with the second expression, and so on with all the
  remaining variables."
  [var-name & expressions]
  `(do ~@(def-vars-helper var-name expressions)))

