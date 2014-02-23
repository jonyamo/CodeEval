-- module Main where
module FindAWriter where

import System.Environment (getArgs)

main = do
  (file:_) <- getArgs
  contents <- readFile file
  putStr $ unlines
         $ map findAWriter
         $ map (splitOn (=='|'))
         $ filter (\x -> length x > 0)
         $ lines contents

-- http://www.haskell.org/haskellwiki/Data.List.Split
splitOn :: (a -> Bool) -> [a] -> [[a]]
splitOn f xs = split xs
  where split xs = case break f xs of
          (chunk,[])     -> chunk : []
          (chunk,_:rest) -> chunk : split rest

findAWriter :: [String] -> String
findAWriter [msg,keys] = [msg !! ((read key :: Int) - 1) | key <- (words keys), length msg > ((read key :: Int) - 1)]
findAWriter [_]        = ""

