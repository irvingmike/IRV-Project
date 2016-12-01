(function($) {
  $(document).ready(function() {

    let choices = $("#choices");

    choices.disableSelection();
    choices.sortable({
      placeholder: "placeholder",
      update: function(e, ui) {
        $("li div.rank").text(function() {
          let ranking = $(this).parent().index("li") - 3;
          $(this).parent().find("input").val(ranking);
          return ranking;
        });
      }
    });

  });

})(jQuery);

function Votes() {
  let pollId;
  let votes;
}
