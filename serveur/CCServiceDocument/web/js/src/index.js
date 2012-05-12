Ext.setup({
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    icon: 'icon.png',
    glossOnIcon: false,
    onReady: function() {
	    var timeline = new Ext.Component({
        title: 'Timeline',  // Name that appears on this tab
        cls: 'timeline',    // The CSS class. Lets you style elements on the timeline.
        scroll: 'vertical', // Make it vertically scrollable
        tpl: [              // Set up a template to display tweet data
          '<tpl for=".">',
            '<div class="tweet">',
              '<div class="avatar"><img src="{profile_image_url}" /></div>', // Tweeter's picture
              '<div class="tweet-content">',
                '<h2>{from_user}</h2>',       // Tweeter's name
                '<p>{text}</p>',              // Tweeter's message
              '</div>',
            '</div>',
        '</tpl>'
       ]
    });
	
	    var map = new Ext.Map({
        title: 'Map',        // Name that appears on this tab
        getLocation: true,   // Gets user's current location
        mapOptions: {        // Used in rendering map
          zoom: 12
        }
    });
	
	    var panel = new Ext.TabPanel({
        fullscreen: true,            // The panel will take up the full rather than partial screen
        cardAnimation: 'slide',       // Special effect for switching between cards
        items: [map, timeline]       // Components (cards) that the tabs correspond with
    });