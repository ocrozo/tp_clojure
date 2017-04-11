(ns elp.balanced)

; Traverse la chaine par récursivité
(defn -traverse [str openCount]
  (cond
    (< openCount 0) false
    (empty? str) (= 0 openCount)
    (= \( (first str)) (-traverse (rest str) (inc openCount))
    (= \) (first str)) (-traverse (rest str) (dec openCount))
    :else (-traverse (rest str) openCount) ))

; Facile
(defn balanced? [str] (-traverse str 0))



; Pour plusieurs chaines de test, renvoie le résultat + la chaine.
(defn check-balanced []
  (let [data '("()" "(())()" ")(" "(()")]
    (map (fn [s] (str (balanced? s) " => " s)) data) ))

; Moche!
(println (check-balanced))

; Plus joli!
(println
  (reduce
    (fn [acc next] (str acc "\n" next))
    "" (check-balanced) ))
