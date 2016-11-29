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

// *****************************

/*
var dragSrcEl = null;
var cols = null;

function init() {
  enableDragDrop();
}

function enableDragDrop() {
  cols = document.querySelectorAll('.choice');
  [].forEach.call(cols, function(col) {
    col.addEventListener('dragstart', handleDragStart, false);
    col.addEventListener('dragenter', handleDragEnter, false);
    col.addEventListener('dragover', handleDragOver, false);
    col.addEventListener('dragleave', handleDragLeave, false);
    col.addEventListener('drop', handleDrop, false);
    col.addEventListener('dragend', handleDragEnd, false);
  });
}

function handleDragStart(e) {
  // Target (this) element is the source node.
  this.style.opacity = '0.4';

  dragSrcEl = this;

  e.dataTransfer.effectAllowed = 'move';
  e.dataTransfer.setData('text/html', this.innerHTML);
}

function handleDragOver(e) {
  if (e.preventDefault) {
    e.preventDefault(); // Necessary. Allows us to drop.
  }

  e.dataTransfer.dropEffect = 'move';  // See the section on the DataTransfer object.

  return false;
}

function handleDragEnter(e) {
  // this / e.target is the current hover target.
  e.classList.add('over');
}

function handleDragLeave(e) {
  this.classList.remove('over');  // this / e.target is previous target element.
}

function handleDrop(e) {
  // this/e.target is current target element.

  if (e.stopPropagation) {
    e.stopPropagation(); // Stops some browsers from redirecting.
  }

  // Don't do anything if dropping the same column we're dragging.
  if (dragSrcEl != this) {
    // Set the source column's HTML to the HTML of the column we dropped on.
    dragSrcEl.innerHTML = this.innerHTML;
    this.innerHTML = e.dataTransfer.getData('text/html');
  }

  return false;
}

function handleDragEnd(e) {
  // this/e.target is the source node.
  var rankNumber = 1;
  [].forEach.call(cols, function (col) {
    col.style.opacity = '1';
    col.classList.remove('over');
    col.getElementsByClassName('rank')[0].innerHTML = rankNumber;
    col.getElementsByTagName('input')[0].value = rankNumber;
    rankNumber++;
  });
}
*/