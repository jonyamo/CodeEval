-- module Main where
module SwapCase where

import Data.Char (toLower, toUpper)
import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map unwords
         $ map (map swapCase)
         $ map words
         $ lines contents

swapCase :: String -> String
swapCase [] = []
swapCase (x:xs)
  | x `elem` ['a'..'z'] = toUpper x : swapCase xs
  | x `elem` ['A'..'Z'] = toLower x : swapCase xs
  | otherwise           =         x : swapCase xs
