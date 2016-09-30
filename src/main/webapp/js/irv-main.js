function init(pageIdentifier) {
  createNavBar(pageIdentifier);
}

function createNavBar(pageIdentifier) {
  var navBarListItems = [
    "My Polls",
    "Create Poll",
    "Account",
    "Log out"
  ];

  navBarListItems.forEach(function(itemName) {
    createNavBarItem(itemName, pageIdentifier);
  });
}

function createNavBarItem(itemName, pageIdentifier) {
  var itemId = itemName.replace(/\s/g,'').toLowerCase();
  var newItem = document.createElement("li");
  newItem.id = itemId;
  newItem.appendChild(document.createTextNode(itemName));
  console.log("****************");
  console.log("pageIdentifier: " + pageIdentifier);
  console.log("itemName: " + itemName);
  if (pageIdentifier == itemName) {
    console.log("Adding selected");
    newItem.className = "selected";
  }
  document.getElementById("navbaritems").appendChild(newItem);
}

/*
function init(pageName) {

  resetNavBarClasses();
  var accountElement = document.getElementById(pageName);
  accountElement.className = "selected";
}

function resetNavBarClasses() {
  var navBarItems = document.getElementById("navbaritems").getElementsByTagName("li");

  for (var i=0; i<navBarItems.length; i++) {
    removeSelectedClass(navBarItems[i]);
  }
}

function removeSelectedClass(item) {
  var previousClasses = item.className.split(' ');
  var newClasses = "";

  previousClasses.forEach(function(className) {
    if (className !== "selected") {
      newClasses = newClasses + ' ' + className;
    }
  });

  item.className = newClasses;
}
*/