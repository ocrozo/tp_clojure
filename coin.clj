(defn compte [objectif pieces]
  (cond
    (= 0 objectif) 1
    (< objectif 0) 0
    (empty? pieces) 0
    :else
      (+ (compte (- objectif (first pieces)) pieces)
         (compte objectif (rest pieces)) )))
(compte 50 '(1 2))
