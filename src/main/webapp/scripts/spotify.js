window.onSpotifyIframeApiReady = (IFrameAPI) => {
    let track = document.getElementById("trackId")
    let element = document.getElementById('embed-iframe');
    let options = {
        uri: 'spotify:track:' + track
    };
    let callback = (EmbedController) => {};
    IFrameAPI.createController(element, options, callback);
};