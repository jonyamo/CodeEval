-- module Main where
module SimpleSorting where

import Data.List (sort)
import System.Environment (getArgs)
import Text.Printf (printf)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map unwords
         $ map process
         $ map words
         $ lines contents

process :: [String] -> [String]
process [] = []
process xs = map (printf "%0.3f")
           $ sort [read x :: Float | x <- xs]
