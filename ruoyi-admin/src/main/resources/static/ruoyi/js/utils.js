
var myTableImageView = function (value, width=200, height=100) {
    if(value == null)
    {
        value = '';
    }
    var flieArr = value.split('.');
    var suffix = flieArr[flieArr.length - 1];
    var videoList = ['mp4', 'rmvb', 'avi', 'flv', 'm2v', 'mkv', 'wmv', 'mp3', 'wav'];
    if(videoList.indexOf(suffix) > -1){
        return "<video src='"+value+"' controls='controls' style='width: auto!important;height: 95px!important;'>你的浏览器不支持播放视频</video>";
    }
    else
    {
        return "<a href='"+value+"' target='_blank'><img class='' style='max-width: "+width+"px;max-height: "+height+"px;' src='"+value+"'/></a>";
    }

};