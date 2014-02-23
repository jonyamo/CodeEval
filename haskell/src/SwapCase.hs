-- CodeEval requires all modules to be called Main.
-- module Main where
module SwapCase where

import Data.Char (toLower, toUpper)
import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines             -- String   : join lines with separating newlines
         $ map unwords         -- String   : join words with separating spaces
         $ map process         -- [String] : process each list of words
         $ map words           -- [String] : create a list of words
         $ lines contents      -- [String] : create a list of lines

process :: [String] -> [String]
process [] = []
process (x:xs) = swapCase x : process xs

swapCase :: String -> String
swapCase [] = []
swapCase (x:xs)
  | x `elem` ['a'..'z'] = toUpper x : swapCase xs
  | x `elem` ['A'..'Z'] = toLower x : swapCase xs
  | otherwise           =         x : swapCase xs
