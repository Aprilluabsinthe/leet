process.stdin.resume();
process.stdin.setEncoding('utf-8');

var binaryBase = {};
var ternaryBase = {};

var __input_stdin = "";
var __input_stdin_array = "";
var __input_currentline = 0;

process.stdin.on('data', function (data) {
    __input_stdin += data;
});


function arrayToTree(array,i) {
    if(i >= array.length){
        return null;
    }
    var root = Object.create(binaryBase);
    root.value = array[i];
    root.left = arrayToTree(array,2*i+1);
    root.right = arrayToTree(array,2*i+2);
    return root;
}

function makeBinaryTree(array) {
    var res = arrayToTree(array,0);
    console.log(res);
    return res;
}

function arrayToTreeTri(array,i) {
    if(i >= array.length){
        return null;
    }
    var root = Object.create(ternaryBase);
    root.value = array[i];
    root.left = arrayToTreeTri(array,3*i+1);
    root.middle = arrayToTreeTri(array,3*i+2);
    root.right = arrayToTreeTri(array,3*i+3);
    return root;
}

function makeTernaryTree(array) {
    var resTri = arrayToTreeTri(array,0);
    console.log(resTri);
    return resTri;
}

function nextStdin() {
    return __input_stdin_array[__input_currentline++].trim() ;
}

function writeTree(tree, wstream, delim) {
    if (tree === undefined) {
        wstream.write("tree node is undefined\n");
    } else if (tree !== null) {
        wstream.write(delim[0]);
        wstream.write(tree.inheritable+"="+tree.value);
        writeTree(tree.left,wstream,['(',')']);
        if ("middle" in tree) {
            wstream.write("*");
            writeTree(tree.middle,wstream,['[',']']);
        }
        writeTree(tree.right,wstream,['{','}']);
        wstream.write(delim[1]);
        return true;
    }
}

var fs = require('fs');
var wstream = fs.createWriteStream(process.env.OUTPUT_PATH);
process.stdin.on('end', function () {
    __input_stdin_array = __input_stdin.split("\n");
    var res;
    var use_ternary = parseInt(nextStdin()) != 0;
    var _array_size = parseInt(nextStdin(), 10);

    var _array = [];
    for(var _array_i = 0; _array_i < _array_size; _array_i++) {
        var _array_item = parseInt(nextStdin(), 10);
        _array.push(_array_item);
    }

    if (use_ternary) {
        res = makeTernaryTree(_array);
        ternaryBase.inheritable = nextStdin();
        writeTree(res,wstream,['<','>']);
    } else {
        res = makeBinaryTree(_array);
        binaryBase.inheritable = nextStdin();
        writeTree(res,wstream,['<','>']);
    }

    wstream.write("\nDONE\n");
    wstream.end();
});
