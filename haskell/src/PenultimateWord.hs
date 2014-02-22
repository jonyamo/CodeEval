-- CodeEval requires all modules to be called Main.
-- module Main where
module PenultimateWord where

import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines             -- String   : join lines with separating newlines
         $ map penultimateWord -- String   : process each list of words
         $ map words           -- [String] : create a list of words
         $ lines contents      -- [String] : create a list of lines

penultimateWord :: [String] -> String
penultimateWord = last . init
