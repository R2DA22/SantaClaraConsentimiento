/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const $itemSelector= document.getElementById('frmFormulario:procedimiento');

const Item=props=>{
    return `<div class="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-active" tabindex="0">
                <input id="frmFormulario:rbtn-si-no-1:0" name="frmFormulario:rbtn-si-no-1" value="true" 
                        class="ui-helper-hidden" checked="checked" type="radio">
                <span class="ui-button-text ui-c">${props.text}</span>
            </div>`;
};

//$itemSelector.innerHTML += Item({text:"prueba"});


$itemSelector.querySelectorAll('.ui-grid-col-6').forEach(div=>{
    div.addEventListener('click',()=>{
        div.classList.toggle('activo');
    });
});