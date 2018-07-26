let searchb = document.getElementById('searchb')

searchb.addEventListener ('click', () => {
   let wantSearch = document.getElementById('searchy').value
   let searchUrl = new URL("http://localhost:3000/pages/albumsearchresults.html");
   searchUrl.searchParams.append('search', wantSearch);
   window.location = searchUrl;
   

})