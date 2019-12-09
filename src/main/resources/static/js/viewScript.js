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
//    drawImage();
}

//function drawImage(){
//    var idIterator = 0;
//    var div = document.getElementById("item-container");
//    var nodelist = div.getElementsByTagName("img").length;
//    var completed_images = 0;
//    var secret = document.getElementById("secretString");
//    secret.value = "";
//    while(completed_images < nodelist){
//        if(document.getElementById("item" + idIterator)){
//            var img = document.getElementById("item" + idIterator);
//            var itemX = document.getElementById("item-x" + idIterator).value;
//            var itemY = document.getElementById("item-y" + idIterator).value;
//
//            secret.value += idIterator + "," + itemX + "," + itemY + "!";
//
//
//            var lowX = document.getElementById("x-min").value;
//            var highX = document.getElementById("x-max").value;
//            var lowY = document.getElementById("y-min").value;
//            var highY = document.getElementById("y-max").value;
//
//            var diffX = highX - lowX;
//            var diffY = highY - lowY;
//
//            if(diffX < 0){
//                diffX *= -1;
//            }
//            if(diffY < 0){
//                diffY *= -1;
//            }
//
//            if(highX != lowX){
//                var intervalX = c.width/(diffX);
//            } else {
//                var intervalX = c.width;
//            }
//            if(highY != lowY){
//                var intervalY = c.height/(diffY);
//            } else {
//                var intervalY = c.height;
//            }
//
//            var itemPosX = 0;
//            if(highX < lowX){
//                itemPosX = lowX - itemX;
//            } else {
//                itemPosX = itemX - lowX;
//            }
//
//            var itemPosY = 0;
//            if(highY < lowY){
//                itemPosY = lowY - itemY;
//            } else {
//                itemPosY = itemY - lowY;
//            }
//
//            document.getElementById("item-x" + idIterator).value = itemX;
//            document.getElementById("item-y" + idIterator).value = itemY;
//
//            ctx.drawImage(img, (itemPosX * intervalX - img.width/2), (itemPosY * intervalY - img.height/2), img.width, img.height);
//            completed_images++;
//        }
//        idIterator++;
//    }
//    var all = document.getElementsByName("secretStringDel");
//    for(var i = 0; i < all.length; i++){
//        all[i].value = secret.value;
//    }
//    document.getElementById("secretStringAdd").value = secret.value;
//}
//
//
//function showData(id){
//     document.getElementById("item-x" + id).hidden = !document.getElementById("item-x" + id).hidden;
//     document.getElementById("item-y" + id).hidden = !document.getElementById("item-y" + id).hidden;
//     document.getElementById("del" + id).hidden = !document.getElementById("del" + id).hidden;
////     document.getElementById("delLabel" + id).hidden = !document.getElementById("delLabel" + id).hidden;
//}
