
(defn integers
  "Return an infinite lazy sequence starting in n."
  [n]
  (lazy-seq (cons n
                  (integers (inc n)))))

(defn pow10
  "Return an infinite lazy sequence of powers of
  10 starting in n."
  [n]
  (lazy-seq (cons n
                  (pow10 (*' n 10)))))

(defn sieve
  "Helper function for computing an infinite lazy
  sequence of prime numbers. Uses the Sieve of
  Eratosthenes algorithm."
  [sequence]
  (lazy-seq (cons
              (first sequence)
              (sieve
                (remove
                  #(zero? (rem % (first sequence)))
                  (rest sequence))))))

;;; This binding contains a lazy sequence with
;;; all prime numbers.
(def primes (sieve (iterate inc 2)))


;;; ------------------------------------------------
;;; Usage examples:

;;; Get the first 10 primes
(take 10 primes)

;;; Get the 99th prime (first prime is 0th)
(nth primes 99)

;;; Get all prime numbers less than 100
(take-while #(< % 100) primes)
