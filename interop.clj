(let [s (new java.util.HashSet)]
  (doto s
    (.add 1)
    (.add 2)
    (.add 3))
  (println (System/currentTimeMillis))
  (println (.contains s 1))
  (println (.contains s 5)) )

(let [l (new java.util.ArrayList)]
  (doto l
    (.add 1)
    (.add 2)
    (.add 3))
  (println (map inc l)))

(defn make-a-class []
  (proxy
    [java.util.ArrayList java.util.concurrent.Callable]
    [12]
    (call [] (clojure.string/join "::" this))
    (toString [] (str "A Callable ArrayList"))  ))

(let [l (make-a-class)]
  (doto l
    (.add 1)
    (.add 2)
    (.add 3)
    (.add 4))g
  (println (.call l))
  (println (.toString l))
  (println (.getClass l)) )
