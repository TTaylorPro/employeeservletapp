//grab all of the elements

const pokeId = document.getElementById('poke-Id');
const respId = document.getElementById('resp-id');
const pokeName = document.getElementById('resp-name');
const pokeImg = document.getElementById('resp-sprite');
const button = document.querySelector('button');

//create a function

function fetchPokemon(){
    //catch info from document
    let idNum = pokeId.value;
    //send a fetch call
    fetch(`https://pokeapi.co/api/v2/pokemon/${idNum}`)
        .then(response => response.json())
        .then(renderPokemon);
    //chain functions to our promise -> parse json into an object then call a function on the object justl ike we just did in out other employee table script
}

function renderPokemon(){

    //sett all of the lement tham aw capte 
    //above equa to the proeperai 
    pokeName.innerHtml = `Name ${data.name}`;
    respId.innerHtml = `Id ${data.id}`;
    
    pokeImg.setAttribute('src', data.sprites.front_default);
    pokeImg.setAttribute('height', 300);
}
//create a function to render a response
button.addEventListener('click', fetchPokemon)

//add an even