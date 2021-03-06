
var elements=document.getElementsByTagName('body')[0].getElementsByTagName("*");
    //alert(elements.length);
    for( i=0; i < elements.length; i++ ){
       if( isVisible(elements[i])){     
	     console.log("visible element: "+ elements[i].tagName);	
             elements[i].setAttribute("element-visible","true");
       }
    } 
function isVisible(obj)
{
    if (obj == document) return true
    
    if (!obj) return false
    if (!obj.parentNode) return false
    if (obj.style) {
        if (obj.style.display == 'none') return false
        if (obj.style.visibility == 'hidden') return false
    }
    
    //Try the computed style in a standard way
    if (window.getComputedStyle) {
        var style = window.getComputedStyle(obj, "")
        if (style.display == 'none') return false
        if (style.visibility == 'hidden') return false
    }
    
    //Or get the computed style using IE's silly proprietary way
    var style = obj.currentStyle
    if (style) {
        if (style['display'] == 'none') return false
        if (style['visibility'] == 'hidden') return false
    }
    
    return isVisible(obj.parentNode)
}
