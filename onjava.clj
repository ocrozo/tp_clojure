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
    (.add 4))
  (println (.call l))
  (println (.toString l))
  (println (.getClass l)) )

(let [fos (new java.io.FileOutputStream "/Users/oscar/hello.gz")
      gzipOS (new java.util.zip.GZIPOutputStream fos)
      osWriter (new java.io.OutputStreamWriter gzipOS "UTF-8")
      writer (new java.io.BufferedWriter osWriter)]
  (doto writer
    (.append "Hello world !" )
    (.close)))
