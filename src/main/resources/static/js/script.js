var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");

drawChart();

function drawChart(){

    ctx.clearRect(0, 0, c.width, c.height);
    var lowX = document.getElementById("x-min").value;
    var highX = document.getElementById("x-max").value;
    var lowY = document.getElementById("y-min").value;
    var highY = document.getElementById("y-max").value;

    var diffX = highX - lowX;
    var diffY = highY - lowY;

    if(diffX < 0){
        diffX *= -1;
    }
    if(diffY < 0){
        diffY *= -1;
    }

    if(highX != lowX){
        var intervalX = c.width/(diffX);
    } else {
        var intervalX = c.width;
    }
    if(highY != lowY){
        var intervalY = c.height/(diffY);
    } else {
        var intervalY = c.height;
    }

    ctx.beginPath();

    for(var i = 1; i < diffX; i++){
        ctx.moveTo((intervalX * i),0);
        ctx.lineTo((intervalX * i),c.height);
        ctx.stroke();
    }

    for(var i = 1; i < diffY; i++){
        ctx.moveTo(0,(intervalY * i));
        ctx.lineTo(c.width,(intervalY * i));
        ctx.stroke();
    }
    ctx.stroke();
    drawImage();
//    drawImages();
}

//function drawImage(){
//
//    var img = document.getElementById("item" + item.path);
//    var itemX = document.getElementById("item-x" + item.id).value;
//    var itemY = document.getElementById("item-y" + item.id).value;
//
////    if(itemX > highX){
////        itemX = highX;
////    }
////    if(itemX < lowX){
////        itemX = lowX;
////    }
////    if(itemY > highY){
////        itemY = highY;
////    }
////    if(itemY < lowY){
////        itemY = lowY;
////    }
//
//    var itemPosX = 0;
//    if(highX < lowX){
//        itemPosX = lowX - itemX;
//    } else {
//        itemPosX = itemX - lowX;
//    }
//
//    var itemPosY = 0;
//    if(highY < lowY){
//        itemPosY = lowY - itemY;
//    } else {
//        itemPosY = itemY - lowY;
//    }
//
////    document.getElementById("item-x").value = itemX;
////    document.getElementById("item-y").value = itemY;
//
//    document.getElementById("item-x" + item.id).value = var itemX;
//    document.getElementById("item-y" + item.id).value = var itemY;
//
//
//    ctx.drawImage(img, (itemPosX * intervalX - img.width/2), (itemPosY * intervalY - img.height/2), img.width, img.height);
//
//
//    document.getElementById("testx").innerHTML = "# line item should rest on for x axis: " + itemPosX;
//    document.getElementById("testy").innerHTML = "# line item should rest on for y axis: " + itemPosY;
//    document.getElementById("testx2").innerHTML = "width of each box: " + intervalX;
//    document.getElementById("testy2").innerHTML = "height of each box: " + intervalY;
//}

function drawImage(){
    var idIterator = 0;
    while(document.getElementById("item" + idIterator)){
        var img = document.getElementById("item" + idIterator);
        var itemX = document.getElementById("item-x" + idIterator).value;
        var itemY = document.getElementById("item-y" + idIterator).value;
//        document.getElementById("testx").innerHTML = "item x " + itemX;
//        console.log(itemX);
//        console.log("item" + idIterator);

        var lowX = document.getElementById("x-min").value;
        var highX = document.getElementById("x-max").value;
        var lowY = document.getElementById("y-min").value;
        var highY = document.getElementById("y-max").value;

        var diffX = highX - lowX;
        var diffY = highY - lowY;

        if(diffX < 0){
            diffX *= -1;
        }
        if(diffY < 0){
            diffY *= -1;
        }

        if(highX != lowX){
            var intervalX = c.width/(diffX);
        } else {
            var intervalX = c.width;
        }
        if(highY != lowY){
            var intervalY = c.height/(diffY);
        } else {
            var intervalY = c.height;
        }

        var itemPosX = 0;
        if(highX < lowX){
            itemPosX = lowX - itemX;
        } else {
            itemPosX = itemX - lowX;
        }

        var itemPosY = 0;
        if(highY < lowY){
            itemPosY = lowY - itemY;
        } else {
            itemPosY = itemY - lowY;
        }

        document.getElementById("item-x" + idIterator).value = itemX;
        document.getElementById("item-y" + idIterator).value = itemY;

        ctx.drawImage(img, (itemPosX * intervalX - img.width/2), (itemPosY * intervalY - img.height/2), img.width, img.height);
//        ctx.drawImage(img, (idIterator*50), (idIterator*50), img.width, img.height);

        idIterator++;
    }
}

function showData(id){
     document.getElementById("item-x" + id).hidden = !document.getElementById("item-x" + id).hidden;
     document.getElementById("item-y" + id).hidden = !document.getElementById("item-y" + id).hidden;
}

//window.addEventListener('load', function() {
//  document.querySelector('input[type="file"]').addEventListener('change', function() {
//      if (this.files && this.files[0]) {
//          var img = document.querySelector('img');  // $('img')[0]
//          img.src = URL.createObjectURL(this.files[0]); // set src to blob url
//          img.onload = imageIsLoaded;
//      }
//  });
//});
//
//function imageIsLoaded() {
//  alert(this.src);  // blob url
//  // update width and height ...
//}

//if(((itemX <= lowX && itemX >= highX) || (itemX >= lowX && itemX <= highX)) && ((itemY <= lowY && itemY >= highY) || (itemY >= lowY && itemY <= highY))){}