-- module Main where
module CapitalizeWords where

import Data.Char (toUpper)
import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map unwords
         $ map capitalizeWords
         $ map words
         $ lines contents

capitalizeWords :: [String] -> [String]
capitalizeWords xs = [capitalizeWord x | x <- xs]

capitalizeWord :: String -> String
capitalizeWord [] = []
capitalizeWord (x:xs) = toUpper x : xs
