(ns acp.schemas-test

  (:require [clojure.test :as test]
    [acp.schemas :as schemas]
    [malli.error :as me]))


(test/deftest ->ToolKind
  (let [valid-tests ["read" "edit" "delete" "move" "search" "execute" "think" "fetch" "switch_mode" "other"]
        invalid-tests ["a" "readl" "Read" "Other"]]
    (doseq [x valid-tests] (test/is (= x (schemas/->ToolKind x))))
    (doseq [x invalid-tests] (test/is (thrown? Exception (schemas/->ToolKind x))) invalid-tests)))
