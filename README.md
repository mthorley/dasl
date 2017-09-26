# Domain Architecture Security Language 

Domain architecture security language (DaSL) is a [DSL](https://en.wikipedia.org/wiki/Domain-specific_language) that aims to describe any logical security architecture in terms of zones, nodes, flows, information assets and controls so that the risk and security posture of a solution can be assessed and improved.

## Features
* Eclipse editor supporting language auto-completion, validation, common file imports, error checking and outline view 
* PlantUML automatic diagram generation 
* Inline model validation highlighting syntatic (language issues) and semantic (rule violations such as invalid zone connections)

## Screenshot
![Dasl Editor](/org.sabsa.lsa.dasl.examples/daslview.png?raw=true "Dasl Editor")

## Basic Example

A simple DaSL for a mobile application calling an API using a security token over TLS1.2. The language is comprised of the following elements:

| Element | Description |
|---------|-------------|
| Zone | Representing network segmentation and separation of nodes and flows |
| Node | A logical representation of an execution environment |
| Component | A product, service, api running on a node  |
| Flow | A flow between components, containing information assets and controls |
| Information Asset | Description of the information, its confidentiality, integrity and availability rating |
| Control | Security or process controls to manage risk |

![Basic Example](/org.sabsa.lsa.dasl.examples/basic/basic.png?raw=true "Basic Example")

```
zone UncontrolledZone {
	trustLevel 0
	ingress 
	egress PerimeterZone
	nodes MobileDevice
}

zone PerimeterZone {
	trustLevel 1
	ingress UncontrolledZone
	egress
	nodes Gateway
}
	
node MobileDevice {
	ref N1
	host "public"
	os "iOS"
	type PHYSICAL
	components MobileApp
}

node Gateway {
	ref N2
	host "aws."
	os "AMI"
	type VIRTUAL
	components APIGateway
}

component MobileApp {
	ref CP1
	stereotype "MobileApp"
	desc "Augmented reality"
	version "Beta"
	assets
}

component APIGateway {
	ref CP2
	stereotype "APIGateway"
	desc "Apigee"
	version "1.0"
	assets
}

informationasset Token {
	ref IA1
	desc "Security token"
	confidentiality Confidential
	integrity Trusted
	availability Gold
}

control TLS12 {
	ref C1
	type MessageSecurity
	implementation "OpenSSL"
}

flow F1 {
	from MobileApp to APIGateway
	assets Token 
	controls TLS12
}
```
## Roadmap

* Doc generation as HTML
* More rules like "All flows must be encrypted for confidential assets"
* Automatically apply attack vectors derived from OWASP top X to key flows/assets
* Implement controls as code, where a control runs tests to validate the security as part of CI/CD pipeline
