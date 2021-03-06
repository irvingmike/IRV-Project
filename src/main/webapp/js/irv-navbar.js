function init(pageIdentifier) {
  var navBarListItems = [
    "My Polls",
    "Create Poll",
    "Account",
    "Log out"
  ];

  switch(pageIdentifier) {
  case "Vote In Poll": pageIdentifier = "My Polls";
  }

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
  }

  var newLink = document.createElement("a");
  if (itemId == "logout") {
    newLink.setAttribute("href", "/" + itemId);
  } else {
    newLink.setAttribute("href", "/voter-access/" + itemId);
  }
  newLink.appendChild(document.createTextNode(itemName));
  newItem.appendChild(newLink);

  document.getElementById("navbaritems").appendChild(newItem);
}
