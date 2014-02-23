-- module Main where
module PenultimateWord where

import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map penultimateWord
         $ map words
         $ lines contents

penultimateWord :: [String] -> String
penultimateWord = last . init
