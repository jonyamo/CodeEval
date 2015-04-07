var fs   = require('fs')
  , file = process.argv[2];

function getDistances (str) {
    var cities = {}
      , sorted_cities = []
      , distances = [];

    str.split(';').forEach(function (city_distance) {
        if (city_distance != "") {
            city_distance = city_distance.split(',');
            cities[city_distance[0]] = city_distance[1];
        }
    });

    sorted_cities = Object.keys(cities).sort(function (a,b) {
        return cities[a] - cities[b];
    });

    for (var i = 0; i < sorted_cities.length; i++) {
        var distance = i == 0 ? 0 : cities[sorted_cities[i-1]];
        distances.push(cities[sorted_cities[i]] - distance);
    }

    return distances;
}

fs.readFile(file, 'utf8', function (err, contents) {
    if (err)
        return console.error(err);

    contents.split('\n').forEach(function (line) {
        if (line != "") {
            var distances = getDistances(line).join(',');
            console.log(distances);
        }
    });
});
