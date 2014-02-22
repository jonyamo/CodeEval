-- CodeEval requires all modules to be called Main.
-- module Main where
module SimpleSorting where

import Data.List (sort)
import System.Environment (getArgs)
import Text.Printf (printf)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines        -- String   : join lines with separating newlines
         $ map unwords    -- String   : join words with separating spaces
         $ map process    -- [String] : process each list of words
         $ map words      -- [String] : create a list of words
         $ lines contents -- [String] : create a list of lines

process :: [String] -> [String]
process [] = []
process xs = map (printf "%0.3f")
           $ sort [read x :: Float | x <- xs]
