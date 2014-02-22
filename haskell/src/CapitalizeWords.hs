-- CodeEval requires all modules to be called Main.
-- module Main where
module CapitalizeWords where

import Data.Char (toUpper)
import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines             -- String   : join lines with separating newlines
         $ map unwords         -- String   : join words with separating spaces
         $ map capitalizeWords -- [String] : process each list of words
         $ map words           -- [String] : create a list of words
         $ lines contents      -- [String] : create a list of lines

capitalizeWords :: [String] -> [String]
capitalizeWords xs = [capitalizeWord x | x <- xs]

capitalizeWord :: String -> String
capitalizeWord [] = []
capitalizeWord (x:xs) = toUpper x : xs
