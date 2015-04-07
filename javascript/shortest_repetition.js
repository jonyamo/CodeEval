var fs = require('fs')
  , f  = process.argv[2];

function unique (value, index, self) {
    return self.indexOf(value) === index;
}

String.prototype.chunks = function (size) {
    var chunks = [];

    if (this.length % size != 0) {
        return chunks;
    }

    for (var i = 0; i < this.length; i += size) {
        chunks.push(this.substr(i, size));
    }

    return chunks;
};

function getSmallestPeriod (str) {
    for (var i = 0; i < str.length/2; i++) {
        var len = i+1
          , chunks = str.chunks(len);

        if (chunks.filter(unique).length == 1)
            return len;
    }

    return str.length;
}

fs.readFile(f, 'utf8', function (err, contents) {
    if (err)
        return console.error(err);

    contents.split('\n').forEach(function (line) {
        if (line != "")
            console.log(getSmallestPeriod(line));
    });
});
