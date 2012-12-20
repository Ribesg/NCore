package com.github.ribesg.ncore.nodes;

import com.github.ribesg.ncore.NCore;

// Represents a Generic plugin
public interface Node {

	// Set to false by afterEnable() call
	// Prevent multiple calls to afterEnable
	boolean loadingComplete = false;

	// Here all nodes should have been loaded by the server
	// So here we're safe to do anything related with which node is activated
	void afterEnable();

	// Setter for Core plugin
	void setCore(NCore core);

	// Getter for Core plugin
	NCore getCore();
}
