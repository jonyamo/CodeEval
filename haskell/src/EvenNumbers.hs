-- module Main where
module EvenNumbers where

import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map oneForEvenZeroForOdd
         $ lines contents

oneForEvenZeroForOdd :: String -> String
oneForEvenZeroForOdd x
  | (read x :: Int) `mod` 2 == 0 = "1"
  | otherwise                    = "0"

