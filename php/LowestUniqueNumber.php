<?php
namespace CodeEval;

class LowestUniqueNumber
{
    protected $submissions;

    public function __construct(array $submissions=array())
    {
        $this->submissions = $submissions;
    }

    public function getWinner()
    {
        $values = array_count_values($this->submissions);
        $singles = array_filter($values, function($n) { return $n == 1; });
        if (count($singles) == 0) {
            return 0;
        }
        ksort($singles);
        $keys = array_keys($singles);
        return array_search($keys[0], $this->submissions) + 1;
    }

    public static function getGamesFromFile($filename)
    {
        $lines = file($filename,
            FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        if ($lines === false) {
            throw new \Exception("Invalid file: {$filename}");
        }
        $games = array();
        foreach ($lines as $line) {
            $submissions = explode(" ", trim($line));
            $games[] = new \CodeEval\LowestUniqueNumber($submissions);
        }
        return $games;
    }
}

$games = \CodeEval\LowestUniqueNumber::getGamesFromFile($argv[1]);
foreach ($games as $game) {
    fwrite(STDOUT, $game->getWinner() . PHP_EOL);
}
