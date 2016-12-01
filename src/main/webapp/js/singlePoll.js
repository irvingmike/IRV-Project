(function($) {
  $(document).ready(function() {
    console.log("JS file works.");

    let pollid = $('pollid').text();

    $('#btnOpen').click(function(){
      let target = 'changepollstatus?status=open&pollid=' + pollid;
      window.location.href=target;
    });

    $('#btnClose').click(function(){
      let target  = 'changepollstatus?status=closed&pollid=' + pollid;
      window.location.href=target;
    });

    $('#btnDetermineWin').click(function(){
      let target  = 'determinewinner?pollid=' + pollid;
      window.location.href=target;
    });

    $('#btnVote').click(function(){
      let target  = 'voteinpoll?pollid=' + pollid;
      window.location.href=target;
    });

  });
})(jQuery)