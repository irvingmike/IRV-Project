function init(pageIdentifier) {
  createNavBar(pageIdentifier);

  switch(pageIdentifier) {
  case "createpoll":
    createPollFunction();
    break;
  }
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

  if (pageIdentifier == itemName) {
    newItem.className = "selected";
    newItem.appendChild(document.createTextNode(itemName));
  } else {
    var newLink = document.createElement("a");
    newLink.setAttribute("href", "/voter-access/" + itemId);
    newLink.appendChild(document.createTextNode(itemName));
    newItem.appendChild(newLink);
  }
  document.getElementById("navbaritems").appendChild(newItem);
}

function createPollFunction() {

}