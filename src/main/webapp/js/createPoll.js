(function($){
  $(document).ready(function() {
    console.log("In ready function");
    $("td.deleteBtn").on("click", function() {
      $(this).parent("tr").remove();
    });
    $("tr:last-child td:last-child").on("click", addNewChoiceItem);
    $("#btnCreatePoll").on("click", submitForm);
  });

  function addNewChoiceItem() {
    console.log("in add choice item");

    $(buildChoiceItem($("#newChoiceItem").val())).insertBefore("tr:last-child");
    $("#newChoiceItem").val("");
  }

  function buildChoiceItem(choiceName) {
    console.log('In buildChoiceItem');
    let newRow = $("<tr>");

    $("<td>", {
      contenteditable: 'true'
    }).text(choiceName).appendTo(newRow);

    $("<td>", {
      class: "deleteBtn"
    }).text("x").on("click", function() {
      $(this).parent("tr").remove();
    }).appendTo(newRow);

    return newRow;
  }

  function submitForm() {
    let poll = new Poll();
    poll.title = $("#title").val();
    poll.description = $("#desc").val();
    poll.choices = [];
    $("td[contenteditable='true']").each(function(index, el) {
      poll.choices.push($(el).text());
    });
    poll.json = JSON.stringify(poll);

    $.ajax({
      url: '/voter-access/generatenewpoll',
      type: 'POST',
      dataType: 'json',
      data: poll,
    })
    .always(function() {
      console.log("complete");
      window.location.href = '/voter-access/mypolls';
    });

  }

})(jQuery);

function Poll() {
  let title;
  let description;
  let choices;
  let json;
}